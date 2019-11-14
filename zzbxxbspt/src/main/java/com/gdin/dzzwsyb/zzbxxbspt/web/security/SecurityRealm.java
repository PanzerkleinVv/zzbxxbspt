package com.gdin.dzzwsyb.zzbxxbspt.web.security;

import java.util.List;
import javax.annotation.Resource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Permission;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Role;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.PermissionService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.RoleService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.UserService;

/**
 * 用户身份验证,授权 Realm 组件
 * 
 **/
public class SecurityRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;

	@Resource
	private RoleService roleService;

	@Resource
	private PermissionService permissionService;

	/**
	 * 权限检查
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		String username = String.valueOf(principals.getPrimaryPrincipal());
		String userPsw = username.substring(username.indexOf("$$") + 2);
		final User user = userService.authentication(new User(username.substring(0, username.indexOf("$$")), userPsw));
		final List<Role> roleInfos = roleService.selectRolesByUserId(user.getUserId());
		for (Role role : roleInfos) {
			// 添加角色
			System.err.println(role);
			authorizationInfo.addRole(role.getRoleSign());

			final List<Permission> permissions = permissionService.selectPermissionsByRoleId(role.getRoleId());
			for (Permission permission : permissions) {
				// 添加权限
				System.err.println(permission);
				authorizationInfo.addStringPermission(permission.getPermSign());
			}
		}
		return authorizationInfo;
	}

	/**
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = String.valueOf(token.getPrincipal()).substring(0,
				String.valueOf(token.getPrincipal()).indexOf("$$"));
		String password = new String((char[]) token.getCredentials());
		// 通过数据库进行验证
		final User authentication = userService.authentication(new User(username, password));
		if (authentication == null) {
			throw new AuthenticationException("用户名或密码错误.");
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(String.valueOf(token.getPrincipal()),
				password, getName());
		return authenticationInfo;
	}

}
