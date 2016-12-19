/**
 * 
 */

var ULR_ENUM = {
	CHECK_LOGIN : '/login/check'
};

function ajaxService(url, data, dataType, success, error) {
	$.ajax({
			'url'		:	url,
			'data'		:	data,
			'dataType'	:	dataType,
			'success'	:	function(data) {
							success(data);
						},
			'error'		:	function(data) {
							error(data);
						}
	});
}