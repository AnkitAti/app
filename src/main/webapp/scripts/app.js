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
		}, 1000);
		$('.login').animate({
			opacity : 1
		}, 1000);
		$('.register').addClass('hide');
		$('.login').removeClass('hide');
	});
	$('#register-id').click(function() {
		$('.links').each(function() {
			$(this).removeClass('selected');
		});
		$(this).parent().addClass('selected');
		$('.login').animate({
			opacity : 0,
		}, 1000);
		$('.register').animate({
			opacity : 1,
		}, 1000);
		$('.register').removeClass('hide');
		$('.login').addClass('hide');
	});
});

function checkLogin() {
	var username  = $('#login-username').val();
	var password = $('#login-password').val();
	
	if(username==null || username=="") {
		$("#login-username").parent().addClass("has-error");
		return false;
	}
	
	if(password==null || password=="") {
		$('#login-password').parent().addClass("has-error");
		return false;
	}
	
	return true;
}

function checkSignup() {
	var username = $('#signup-username').val();
	var email = $('#signup-email').val();
	var password = $('#signup-password').val();
	
	if(username==null || username=="") {
		$('#signup-username').parent().addClass("has-error");
		return false;
	}
	
	if(email==null || email=="") {
		$("#signup-email").parent().addClass("has-error");
		return false;
	}
	
	if(password==null || password=="") {
		$("#signup-password").parent().addClass("has-error");
		return false;
	}
	return true;
}