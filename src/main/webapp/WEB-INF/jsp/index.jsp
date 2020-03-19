<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="jumbotron">
			<h1 class="display-4">Mailing Application</h1>
			<p class="lead">This is a Spring JAVA Web Application that
				utilizes session and cookies to login and show users Inbox messages.</p>
			<hr class="my-4">
			<p>Here is all your messages "${username}".</p>

			<div class="row justify-content-center">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">#</th>
							<th scope="col">ID</th>
							<th scope="col">Message</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${msgList}" var="msg" varStatus="loop">
							<tr>
								<th scope="row">${loop.index + 1}</th>
								<td>${msg.getId()}</td>
								<td>${msg.getMessage()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>