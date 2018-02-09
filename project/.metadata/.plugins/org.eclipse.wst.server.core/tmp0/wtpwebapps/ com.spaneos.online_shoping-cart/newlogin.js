
$(function() {

	var $formLogin = $('#login-form');
	var $formLost = $('#lost-form');
	var $formRegister = $('#register-form');
	var $adminlogin = $('#adminlogin-form')
	var $divForms = $('#div-forms');
	var $modalAnimateTime = 300;
	var $msgAnimateTime = 150;
	var $msgShowTime = 2000;

	$('#login_register_btn').click(function() {
		modalAnimate($formLogin, $formRegister)
	});

	$('#icon-login-msg1').click(function() {
		modalAnimate($formLogin, $adminlogin)
	});
	$('#icon-login-msg2').click(function() {
		modalAnimate($adminlogin, $formLogin)
	});

	$('#login_modal1').click(function() {
		modalAnimate($formRegister, $formLogin)
	});
	$('#adminlogin_btn').click(function() {
		modalAnimate($formRegister, $formLogin)
	});
	$('#register_login_btn').click(function() {
		modalAnimate($formRegister, $formLogin);
	});
	$('#login_lost_btn').click(function() {
		modalAnimate($formLogin, $formLost);
	});
	$('#lost_login_btn').click(function() {
		modalAnimate($formLost, $formLogin);
	});
	$('#lost_register_btn').click(function() {
		modalAnimate($formLost, $formRegister);
	});
	$('#register_lost_btn').click(function() {
		modalAnimate($formRegister, $formLost);
	});
});