//package cn.slyang.service.sso.shiro;
//
//import io.xgo.bbs.bean.table.User;
//import io.xgo.bbs.service.UserPermissionService;
//import io.xgo.bbs.service.UserRoleService;
//import io.xgo.bbs.service.UserService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.utils.Set;
//
///**
// * 认证，授权 管理
// * Created by slyang on 17/6/21.
// */
//public class JDBCRealm extends AuthorizingRealm {
//
//
//	@Override
//	public String getName() {
//		return "JDBCRealm";
//	}
//
//	@Override
//	public boolean supports(AuthenticationToken token) {
//		return token instanceof UsernamePasswordToken;
//	}
//
//	@Autowired
//	private UserRoleService userRoleService;
//	@Autowired
//	private UserPermissionService userPermissionService;
//	@Autowired
//	private UserService userService;
//
//	// 认证
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//
//		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
//
//		String username = usernamePasswordToken.getUsername();
//		String password = new String(usernamePasswordToken.getPassword());
//
//		//查询用户信息
//		User userT = userService.findUser(username);
//
//		//账号不存在
//		if (userT == null) {
//			throw new UnknownAccountException("账号或密码不正确");
//		}
//
//		//密码错误
//		if (!password.equals(userT.getPassword())) {
//			throw new IncorrectCredentialsException("账号或密码不正确");
//		}
//
////		//账号锁定
////		if(user.getStatus() == 0){
////			throw new LockedAccountException("账号已被锁定,请联系管理员");
////		}
//
//		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userT, password, getName());
//
//		return info;
//	}
//
//
//	// 授权
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//
//		User user = (User) principals.getPrimaryPrincipal();
//		int userId = user.getId();
//
//		//用户权限列表
//		Set<String> permsSet = userPermissionService.getAllPermissionById(userId);
//		//用户角色列表
//		Set<String> roleSet = userRoleService.getAllUserRoleNameById(userId);
//
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.setStringPermissions(permsSet);
//		info.setRoles(roleSet);
//
//		return info;
//	}
//
//}
