/**
 * 
 */

$(document).ready(function () {
	$("#loginModal").on("shown.bs.modal", function () {
		$("#login-username").focus();
	});
	$("#signupModal").on("shown.bs.modal", function() {
		$("#signup-username").focus();
	});
	
	if($("#login-error").length == 1) {
		$("#loginModal").modal('show');
	} else if($("#signup-error").length == 1) {
		$("#signupModal").modal('show');
	}
		
	$('#loginModal').on('hidden.bs.modal', function () {
		$('#login-username').val("");
		$('#login-username').parent().removeClass("has-error");
		$('#login-password').val("");
		$('#login-password').parent().removeClass("has-error");
	});
	
	$('#signupModal').on('hidden.bs.modal', function () {
		$('#signup-username').val("");
		$('#signup-username').parent().removeClass("has-error");
		$('#signup-email').val("");
		$('#signup-email').parent().removeClass("has-error");
		$('#signup-password').val("");
		$('#signup-password').parent().removeClass("has-error");
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