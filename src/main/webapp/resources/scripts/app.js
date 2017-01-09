/**
 * 
 */

$(document).ready(function () {
	$('#login-id').click(function() {
		$('.links').each(function() {
			$(this).removeClass('selected');
		});
		$(this).parent().addClass('selected');
		$('.register').animate({
			opacity : 0,
			scale : 0
		}, {
			duration : 200,
			complete : function() {
				$('.register').addClass('hide');
				$('.login').removeClass('hide');
				$('.login').animate({
					opacity : 1,
					scale : 1
				}, 200);
			}
		});
		return false;
	});
	$('#register-id').click(function() {
		$('.links').each(function() {
			$(this).removeClass('selected');
		});
		$(this).parent().addClass('selected');
		$('.login').animate({
			opacity : 0,
			scale : 0
		}, {
			duration : 200,
			complete : function() {
				$('.login').addClass('hide');
				$('.register').animate({
					opacity : 1,
					scale : 1
				}, 200);
				$('.register').removeClass('hide');
			}
		});
		return false;
	});
	if($('#show-signup').length > 0) {
		$("#register-id").trigger('click');
	}
});

function checkLogin() {
	var username  = $('#login-username').val();
	var password = $('#login-password').val();
	$("#login-username").removeClass("has-error");
	$("#login-password").removeClass("has-error");
	if(username==null || username.trim()=="") {
		$("#login-username").addClass("has-error");
		setErrorMsg('Please enter a valid username');
		return false;
	} else {
		$("#login-username").removeClass("has-error");
	}
	
	if(password==null || password.trim()=="") {
		$('#login-password').addClass("has-error");
		setErrorMsg('Please enter a valid password');
		return false;
	} else {
		$('#login-password').removeClass("has-error");
	}
	
	return true;
}

function checkSignup() {
	var username = $('#signup-username').val();
	var email = $('#signup-email').val();
	var password = $('#signup-password').val();
	
	$("#signup-username").removeClass("has-error");
	$("#signup-email").removeClass("has-error");
	$("#signup-password").removeClass("has-error");
	if(username==null || username=="" || username.trim()=="") {
		$('#signup-username').addClass("has-error");
		setErrorMsg('Please enter a valid username');
		return false;
	} else {
		$('#signup-username').removeClass("has-error");
	}
	
	if(email==null || email.trim()=="" || (!validateEmail(email))) {
		$("#signup-email").addClass("has-error");
		$('#signup-email').css({'color' : 'red'});
		setErrorMsg('Please enter a valid email');
		return false;
	} else {
		$("#signup-email").removeClass("has-error");
	}
	
	if(password==null || password.trim()=="" || password.trim().length < 5) {
		$("#signup-password").addClass("has-error");
		setErrorMsg('Please enter a valid password');
		return false;
	} else {
		$("#signup-password").removeClass("has-error");
	}
	return true;
}

function setErrorMsg(msg) {
	if($('.error').length <= 0)
		$('#error-msg').html('<div class="error"><h3>'+msg+'</h3></div>');
	else 
		$('.error').html('<h3>' + msg + '</h3>');
}

function validateEmail(email) {
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}
if(typeof String.prototype.trim !== 'function') {
  String.prototype.trim = function() {
    return this.replace(/^\s+|\s+$/g, ''); 
  }
}