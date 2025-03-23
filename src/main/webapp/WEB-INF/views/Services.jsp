<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>NeoBank - Services</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/homepageStyle.css">
</head>

<body>
	<c:if test="${param.showPopup == 'fundTransferPopup'}">
        <script>
        	window.onload = function(){
            	showPopup('fundTransferPopup');
        	}
        </script>
    </c:if>

	<div id="header-placeholder"></div>
	
	<main class="servicesContainer">
		<h1>Our Services</h1>
		<div class="serviceItems">
			<div class="serviceItem" onclick="showPopup('viewBalancePopup')">
				<h2>View Balance</h2>
			</div>

			<div class="serviceItem" onclick="showPopup('editAccountPopup')">
				<h2>Edit Account Info</h2>
			</div>
			<div class="serviceItem" onclick="showPopup('depositPopup')">
				<h2>Deposit</h2>
			</div>
			<div class="serviceItem" onclick="showPopup('fundTransferPopup')">
				<h2>Fund Transfer</h2>
			</div>
			<div class="serviceItem"
				onclick="showPopup('transactionHistoryPopup')">
				<h2>Transaction History</h2>
			</div>
		</div>
	</main>

	<div id="footer-placeholder"></div>

	<div id="viewBalancePopup" class="popupContainer">
		<div class="popupContent">
			<h2>Current Balance</h2>
			<label>${balance}</label>
			<button onclick="closePopup('viewBalancePopup')">Close</button>
		</div>
	</div>

	<div id="editAccountPopup" class="popupContainer">
		<div class="popupContent">
			<h2>Edit Account Info</h2>
			<form:form modelAttribute="editInfo" action="processAccountInfo"
				method="POST">
				<label for="editName">Name</label>
				<form:input type="text" path="name" id="editName" name="editName"
					placeholder="Name" required="true" />

				<label for="editAddress">Address</label>
				<form:input type="text" path="address" id="editAddress"
					name="editAddress" placeholder="Address" required="true" />

				<label for="editContact">Contact Number</label>
				<form:input type="number" path="contact" id="editContact"
					name="editContact" placeholder="Contact Number" required="true" />
				
				<input type="submit" value="Save Changes">
			</form:form>
			<button onclick="closePopup('editAccountPopup')">Close</button>
		</div>
	</div>

	
	<div id="depositPopup" class="popupContainer">
		<div class="popupContent">
			<h2>Deposit</h2>
			<form:form modelAttribute="deposit" action="processDeposit"
				method="POST">
				<label for="depositAccountNumber">Account Number</label>
				<form:input path="acctNum" id="depositAccountNumber"
					name="depositAccountNumber" placeholder="Account Number"
					readOnly="true" />

				<label for="depositAmount">Deposit Amount</label>
				<form:input type="number" path="amount" id="depositAmount"
					name="depositAmount" placeholder="Deposit Amount" min = "100" max="500000"
					required="true" />

				<input type="submit" value="Deposit">
			</form:form>
			<button onclick="closePopup('depositPopup')">Close</button>
		</div>
	</div>

	<div id="fundTransferPopup" class="popupContainer">
		<div class="popupContent">
			<h2>Fund Transfer</h2>
			<form:form action="processTransfer" modelAttribute="transfer"
				method="POST">
				<label for="transferFromAccount">From Account</label>
				<form:input path="sourceAcct" id="transferFromAccount"
					name="transferFromAccount" placeholder="From Account"
					readOnly="true" />

				<label for="transferToAccount">To Account</label>
				<form:input type="number" path="destinationAcct"
					id="transferToAccount" name="transferToAccount"
					placeholder="To Account" required="true" />
				<form:errors path="destinationAcct"></form:errors>

				<label for="transferAmount">Transfer Amount</label>
				<form:input type="number" path="amount" id="transferAmount"
					name="transferAmount" placeholder="Transfer Amount" min="100" max="500000"
					required="true" />

				<input type="submit" value="Transfer">
			</form:form>
			<button onclick="closePopup('fundTransferPopup')">Close</button>
		</div>
	</div>
	
	<div id="transactionHistoryPopup" class="popupContainer">
		<div class="popupContent">
			<h2>Transaction History</h2>
			<hr>
			<table class="table table-hover">
				<tr>
					<th>Transaction Type</th>
					<th>Amount</th>
					<th>Transaction Date</th>
				</tr>

				<c:forEach var="transaction" items="${transaction}">
					<tr>
						<td>${transaction.type}</td>
						<td>${transaction.amount}</td>
						<td>${transaction.transactionDate}</td>
					</tr>
				</c:forEach>

			</table>

			<button onclick="closePopup('transactionHistoryPopup')">Close</button>
		</div>
	</div>
	
	<input type="hidden" id="failedMessage" value="${failedMessage}" />

	<script>
		function showPopup(popupId) {
			document.getElementById(popupId).style.display = 'block';
		}

		function closePopup(popupId) {
			document.getElementById(popupId).style.display = 'none';
		}
	</script>

	<script src="${pageContext.request.contextPath}/javascript/insertHeaderFooter.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/messages.js"></script>
</body>

</html>
