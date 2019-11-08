package com.gdin.dzzwsyb.zzbxxbspt.web.security;

/**
 * 角色标识配置类, <br>
 * 与 role_info 角色表中的 role_sign 字段 相对应 <br>
 * 使用:
 * 
 * <pre>
 * &#064;RequiresRoles(value = RoleSign.ADMIN)
 * public String admin() {
 * 	return &quot;拥有admin角色,能访问&quot;;
 * }
 * </pre>
 * 
 **/
public class RoleSign {

	public static final String ADMIN = "admin";

	public static final String TEACHER = "teacher";

	public static final String STUDENT = "student";

}
