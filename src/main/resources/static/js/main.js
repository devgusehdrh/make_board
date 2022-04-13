
$(document).ready(function(){
	listing();
});

// 사용자가 내용을 올바르게 입력하였는지 확인합니다.
function isValidContents(contents) {
	if (contents == '') {
		alert('내용을 입력해주세요');
		return false;
	}
	if (contents.trim().length > 140) {
		alert('공백 포함 140자 이하로 입력해주세요');
		return false;
	}
	return true;
}

// 게시판 양식을 위해 필요한 부분
(function ($) {
	"use strict";
	$('.column100').on('mouseover',function(){
		var table1 = $(this).parent().parent().parent();
		var table2 = $(this).parent().parent();
		var verTable = $(table1).data('vertable')+"";
		var column = $(this).data('column') + ""; 

		$(table2).find("."+column).addClass('hov-column-'+ verTable);
		$(table1).find(".row100.head ."+column).addClass('hov-column-head-'+ verTable);
	});

	$('.column100').on('mouseout',function(){
		var table1 = $(this).parent().parent().parent();
		var table2 = $(this).parent().parent();
		var verTable = $(table1).data('vertable')+"";
		var column = $(this).data('column') + ""; 

		$(table2).find("."+column).removeClass('hov-column-'+ verTable);
		$(table1).find(".row100.head ."+column).removeClass('hov-column-head-'+ verTable);
	});
})(jQuery);

// 포스트 불러오기
function listing() {
	$('#posts-box').empty()
	$.ajax({
		type: 'GET',
		url: '/api/posts',
		data: {},
		success: function(response){
			let post = response
			for(let i = 0; i < post.length; i++){
				let post_id = response[i]['post_id']
				let post_subject = response[i]['post_subject']
				let post_username = response[i]['post_username']
				let createdAt = response[i]['createdAt']

				let temp_html = `
				<tr class="row100 body" id="post_${post_id}" onclick="location.href='/api/posts/${post_id}'">
                            <td class="cell100 column1">${post_subject}</td>
                            <td class="cell100 column2">${post_username}</td>
                            <td class="cell100 column3">${createdAt}</td>
                </tr>
				`
				$('#posts-box').append(temp_html)

			}
		}
	})
}

// 포스트 작성
function posting() {
	let post_subject = $('#post-subject').val();
	let post_username = $('#post-username').val();
	let post_contents = $('#textarea-post').val();


	if(isValidContents(post_contents) == false) {
		return;
	}

	let data = {'post_subject':post_subject,'post_username':post_username, 'post_contents':post_contents};
	$.ajax({
		type:"POST",
		url:"/api/posts",
		contentType: "application/json",
		data: JSON.stringify(data),
		success: function(response){
			alert('메시지가 작성되었습니다');
			window.location.reload();
		}
	});
}

// 포스트 수정
function modifying(post_id) {
	let post_subject = $(`#${post_id}-subject`).text().trim();
	let post_username = $(`#${post_id}-username`).text().trim();
	let post_contents = $(`#${post_id}-contents`).text().trim();

	if(isValidContents(post_contents) == false){
		return;
	}
	let data = {'post_subject':post_subject,'post_username':post_username, 'post_contents':post_contents};

	$.ajax({
		type: "PUT",
		url: `/api/posts/${post_id}`,
		contentType: "application/json",
		data: JSON.stringify(data),
		success: function(response){
			alert('메시지가 수정되었습니다');
			window.location.reload();
		}
	});
}

// 포스트 삭제
function deleting(post_id){
	$.ajax({
		type: "DELETE",
		url: `/api/posts/${post_id}`,
		success: function(response){
			alert('메시지가 삭제되었습니다');
			window.location.reload();
		}
	})
}
