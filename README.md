# ParamCheck

参数检测，可用于后台服务和Android前端进行参数的检测
后台可调用方法 ParamCheckUtils.check(Object obj)进行检测，该方法调用一旦检测失败会抛出异常，在全局进行异常捕获即可处理客户端的请求参数
Android 检测参数调用aramsCheckResult checkParam(Object object)进行检测，可以返回ParamsCheckResult对象对检测结果进行返回。

例如：
public class LoginReqParam {

    @ParamNotNull
    @ParamAliasName(aliasName = "手机号码")
    @ParamInputType(inputType = InputType.MobilePhone)
    private String userAccount;


    @ParamNotNull
    @ParamAliasName(aliasName = "密码")
    @ParamLength(lengthModel = LengthModel.Region, value = {6, 16})
    private String userPassword;
}


可在字段上对需要检测的字段进行标注，可设置一个字段别名，会对返回的字段名字进行转化返回，目前支持 非空检测，长度检测，长度检测支持最小，最大，区间长度，类型检测支持 电话号码，数字，邮箱，url等常用格式检测



gradle

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
        dependencies {
	   implementation 'com.github.Hankun9524:ParamCheck:1.0.0'
	}


maven

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
	
	<dependency>
	    <groupId>com.github.Hankun9524</groupId>
	    <artifactId>ParamCheck</artifactId>
	    <version>1.0.0</version>
	</dependency>
	
