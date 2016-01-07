$(function() {
	/*
	 * 2. 给注册按钮添加submit()事件，完成表单校验
	 */
	$("#loginForm").submit(function(){
		$("#msg").text("");
		var bool = true;
		$(".input").each(function() {
			var inputName = $(this).attr("name");
			if(!invokeValidateFunction(inputName)) {
				bool = false;
			}
		});
		return bool;
	});
	
	/*
	 * 3. 输入框得到焦点时隐藏错误信息
	 */
	$(".input").focus(function() {
		var inputName = $(this).attr("name");
		$("#" + inputName + "Error").css("display", "none");
	});
	
	/*
	 * 4. 输入框推动焦点时进行校验
	 */
	$(".input").blur(function() {
		var inputName = $(this).attr("name");
		invokeValidateFunction(inputName);
	})

	$("#submit").click(function(){
		$("#loginForm").submit();
	});
});

/*
 * 输入input名称，调用对应的validate方法。
 * 例如input名称为：username，那么调用validateUsername()方法。
 */
function invokeValidateFunction(inputName) {
	inputName = inputName.substring(0, 1).toUpperCase() + inputName.substring(1);
	var functionName = "validate" + inputName;
	return eval(functionName + "()");	
}

/*
 * 校验登录名
 */
function validateUsername() {
	var bool = true;
	$("#loginnameError").css("display", "none");
	var value = $("#username").val();
	if(!value) {// 非空校验
		$("#loginnameError").css("display", "");
		$("#loginnameError").text("用户名不能为空！");
		bool = false;
	} else if(value.length < 3 || value.length > 20) {//长度校验
		$("#loginnameError").css("display", "");
		$("#loginnameError").text("用户名长度必须在3 ~ 20之间！");
		bool = false;
	}
	return bool;
}

/*
 * 校验密码
 */
function validatePassword() {
	var bool = true;
	$("#loginpassError").css("display", "none");
	var value = $("#password").val();
	if(!value) {// 非空校验
		$("#loginpassError").css("display", "");
		$("#loginpassError").text("密码不能为空！");
		bool = false;
	} else if(value.length < 3 || value.length > 20) {//长度校验
		$("#loginpassError").css("display", "");
		$("#loginpassError").text("密码长度必须在3 ~ 20之间！");
		bool = false;
	}
	return bool;
}




