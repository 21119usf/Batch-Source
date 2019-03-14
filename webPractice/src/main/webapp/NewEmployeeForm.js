/*
 * New Employee Reimbursement Form
 */
$('#getNewForm').click( function() {
        $('#formInfo').load('EmployeeReimForm.html .row').hide().fadeIn('slow');
});