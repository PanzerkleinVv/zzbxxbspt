package com.gdin.dzzwsyb.zzbxxbspt.web.security;

/**
 * 权限标识配置类, <br>
 * 与 permission 权限表 中的 permission_sign 字段 相对应 <br>
 * 使用:
 * 
 * <pre>
 * &#064;RequiresPermissions(value = PermissionConfig.USER_CREATE)
 * public String create() {
 * 	return &quot;拥有user:create权限,能访问&quot;;
 * }
 * </pre>
 **/
public class PermissionSign {

	public static final String CREATE_GROUP = "create_group";

	public static final String ADMIN_TEACHER = "admin_teacher";

	public static final String ADMIN_LOG = "admin_log";

	public static final String CREATE_QUESTION = "create_question";

	public static final String ADMIN_STUDENT = "admin_student";

	public static final String ANALYSIS_EXAM = "analysis_exam";

	public static final String EXAM = "exam";

	public static final String ADMIN_EXAM = "admin_exam";

}
