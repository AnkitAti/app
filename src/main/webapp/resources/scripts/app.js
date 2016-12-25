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
			duration : 500,
			complete : function() {
				$('.register').addClass('hide');
				$('.login').removeClass('hide');
				$('.login').animate({
					opacity : 1,
					scale : 1
				}, 500);
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
			duration : 500,
			complete : function() {
				$('.login').addClass('hide');
				$('.register').animate({
					opacity : 1,
					scale : 1
				}, 500);
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
	
	if(username==null || username=="") {
		$("#login-username").addClass("has-error");
		return false;
	} else {
		$("#login-username").removeClass("has-error");
	}
	
	if(password==null || password=="") {
		$('#login-password').addClass("has-error");
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
	
	if(username==null || username=="") {
		$('#signup-username').addClass("has-error");
		return false;
	} else {
		$('#signup-username').removeClass("has-error");
	}
	
	if(email==null || email=="") {
		$("#signup-email").addClass("has-error");
		return false;
	} else {
		$("#signup-email").removeClass("has-error");
	}
	
	if(password==null || password=="") {
		$("#signup-password").addClass("has-error");
		return false;
	} else {
		$("#signup-password").removeClass("has-error");
	}
	return true;
}