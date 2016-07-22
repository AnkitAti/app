/**
 * 
 */

$(document).ready(function () {
	$("#loginModal").on("shown.bs.modal", function () {
		$("#login-username").focus();
	});
	$("signupModal").on("shown.bs.modal", function() {
		$("#signup-username").focus();
	});
	
	if($("#login-error").children().length>0) {
		$("#loginModal").modal('show');
	} else if($("#signup-error").children().length>0) {
		$("#signupModal").modal('show');
	}
	
});

function checkLogin() {
	var username  = $('#login-username').val();
	var password = $('#login-password').val();
	
	if(username==null || username=="") {
		$("#login-username").addClass("hasError");
		return false;
	}
	
	if(password==null || password=="") {
		$('#login-password').addClass("hasError");
		return false;
	}
	
	return true;
}

function checkSignup() {
	var username = $('#signup-username').val();
	var email = $('#signup-email').val();
	var password = $('#signup-password').val();
	
	console.log(username + " " + email + " " + password);
	
	return false;
}