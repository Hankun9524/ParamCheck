# ParamCheck

参数检测，可用于后台服务和Android前端进行参数的检测
后台可调用方法 ParamCheckUtils.check(Object obj)进行检测，该方法调用一旦检测失败会抛出异常，在全局进行异常捕获即可处理客户端的请求参数
Android 检测参数调用aramsCheckResult checkParam(Object object)进行检测，可以返回ParamsCheckResult对象对检测结果进行返回。


1 Add it in your root build.gradle at the end of repositories:

gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

dependencies {
	   implementation 'com.github.Hankun9524:ParamCheck:1.0.0'
	}
