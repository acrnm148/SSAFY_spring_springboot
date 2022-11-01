<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>DB Test (using JSON)</h1>
	<button id="btnUserDetail">user 상세</button>
	<button id="btnUserList">user 목록</button>
	<br>
	
	<button id="btnUserInsert">user 등록</button>
	<button id="btnUserUpdate">user 수정</button>
	<button id="btnUserDelete">user 삭제</button>
	
	<script>
		window.onload=function() {
			document.querySelector("#btnUserDetail").onclick=async function() {
				
				try{
					let response = await fetch("/mydb/userDetail/1500");
					let data = await response.json();
					console.log(data);
				} catch(error) {
					console.error(error);
				}
			}
			
			document.querySelector("#btnUserList").onclick=async function() {
				
				try{
					let response = await fetch("/mydb/userList");
					let data = await response.json();
					console.log(data);
				} catch(error) {
					console.error(error);
				}
			}
			
			// javascript 객체
			var userInsertData = {
					id: 'sunkang',
					password: '강',
					name: '길동',
					email: 'you@gildong.com',
					age: 24
			}
			
			document.querySelector("#btnUserInsert").onclick=async function() {
				
				let urlParams = new URLSearchParams(userInsertData);
				let fetchOptions = {
						method: 'POST',
						body: urlParams
				}
				
				try{
					let response = await fetch("/mydb/userInsert", fetchOptions);
					let data = await response.json();
					console.log(data);
				} catch(error) {
					console.error(error);
				}
			}
			
			// javascript 객체
			var userUpdatetData = {
					id: 'sunkang',
					password: '강',
					name: '길동',
					email: 'suna@gildong.com',
					age: 24
			}
			document.querySelector("#btnUserUpdate").onclick=async function() {
				
				let urlParams = new URLSearchParams(userUpdatetData);
				let fetchOptions = {
						method: 'POST',
						body: urlParams
				}
				
				try{
					let response = await fetch("/mydb/userUpdate", fetchOptions);
					let data = await response.json();
					console.log(data);
				} catch(error) {
					console.error(error);
				}
			}
			
			document.querySelector("#btnUserDelete").onclick=async function() {
				
				let urlParams = new URLSearchParams({ id: 1600 });
				let fetchOptions = {
						method: 'POST',
						body: urlParams
				}
				
				try{
					let response = await fetch("/mydb/userDelete", fetchOptions);
					let data = await response.json();
					console.log(data);
				} catch(error) {
					console.error(error);
				}
}
		}
	
	</script>
</body>
</html>