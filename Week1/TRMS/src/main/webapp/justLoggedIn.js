$(function() {
	getInfo();
});

function getInfo () {
	var root = document.getElementById("fillIn");
	url = '/TRMS/EmployeeHome';
	$.get(url, (data, status) => {
    	//console.log(data);
		table(data);
    	//renderReimbursement(data);
    	/*
    	for(let i = 0; i < data.length; i++){
    		var idheader = document.createElement("h5")
        	idheader.textContent = "Id: "+data[i].id;
        	root.appendChild(idheader);
    	}*/
    	
    	//console.log(data[0].id)
    	//for(let item=0; item<data.length; item++){
    		//id.textContent = "ID: "+ data[item].id;
    		//root.appendChild(idheader);
    		//renderReimbursement(item)
    	//}
    });
}
function table(data) {
    let trHTML = '';

    $.each(data, function(i, item) {
        trHTML += '<tr><td class="requestID">';
        trHTML += item.id + '</td><td>';
        trHTML += item.cost + '</td><td>';
        trHTML += item.approvalStatus + '</td><td>';
        trHTML += new Date(item.date).toDateString() + '</td><td>';
        if(item.employee_id =! item.inCharge){
        	trHTML += '</td><td>'
        }else {
            trHTML += '<button type="button" class="btn btn-success approve">Approve</button><span class="paddRight5px"></span><button type="button" class="btn btn-danger deny">Reject</button>'+'</td><td>';
        }
        trHTML += '<button type="button" class="btn btn-primary edit">Edit</button>' + '</td><td>';
        if(item.approvalStatus != 4){
        	trHTML += '</td><td>';
        }else {
            trHTML += '<button type="button" class="btn btn-primary accept">Accept</button>' + '</td><td>';
        }
        trHTML += '</td></tr>';
    });

    $('#fillIn').append(trHTML);
    
    $('.approve').click(function() {
		let requestID = $(this).closest("tr").find(".requestID").text();

		//console.log(requestID);
		
		url = '/TRMS/ButtonServlet';
		data = {
			id: requestID,
			btn: "approve"
		}
		// do ajax call here
	    
	    $.post(url, JSON.stringify(data), (data, status) => {
	    	console.log(data);
	    });
	});
    
    $('.deny').click(function() {
		let requestID = $(this).closest("tr").find(".requestID").text();

		//console.log(requestID);
		
		url = '/TRMS/ButtonServlet';
		data = {
				id: requestID,
				btn: "deny"
			}
		
		// do ajax call here
		$.post(url, JSON.stringify(data), (data, status) => {
	    	console.log(data);
	    });
	});
    
    $('.edit').click(function() {
		let requestID = $(this).closest("tr").find(".requestID").text();

		//console.log(requestID);
		url = '/TRMS/ButtonServlet';
		data = {
				id: requestID,
				btn: "edit"
			}
		
		// do ajax call here
		$.post(url, JSON.stringify(data), (data, status) => {
	    	console.log(data);
	    });
	});
    
    $('.accept').click(function() {
		let requestID = $(this).closest("tr").find(".requestID").text();

		//console.log(requestID);
		url = '/TRMS/ButtonServlet';
		data = {
				id: requestID,
				btn: "accept"
			}
		
		// do ajax call here
		$.post(url, JSON.stringify(data), (data, status) => {
	    	console.log(data);
	    });
	});
}
/*
function renderReimbursement(reimbursements){
	var tablecontents = "";
	console.log("in here")
	console.log(reimbursements)
    for (var i = 0; i < reimbursements.length; i++) {
    	console.log("in hea")
        tablecontents += "<tr>";
        for (var j = 0; j < reimbursements[i].length; j++) {
        	console.log("in Re")
            tablecontents += "<td>" + reimbursements[i][j] + "</td>";
        }
        tablecontents += "</tr>";
    }
    document.getElementById("fillIn").innerHTML += tablecontents;
}*/