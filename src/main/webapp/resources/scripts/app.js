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
});

$(window).scroll(function() {
	var wScroll = $(this).scrollTop();
	console.log(wScroll);
	$('.app-name').css({
		'transform' : 'translate(0,'+wScroll*0.7+'px)'
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