function remove(){
		var selectElement = document.getElementById('account_transfer');
		var t =document.getElementById('hello').innerHTML;
		for (var i =0;i< selectElement.length;i++){
			if( selectElement[i].value == t)
			{
				selectElement.remove(i);		
			}
		}
		for (var i =0;i< selectElement.length;i++){
			if(  selectElement[i].value == 0)
			{
				selectElement.remove(i);		
			}
		}
	
	}

/*function validate(){
	
	var balance = document.getElementById('balance-now');
	var amount = document.getElementById('amount');
	var account_transfer = document.getElementById('account_transfer');
	
	var errAmount = document.getElementById('err-amount');
	{if(amount.value==""){
		amount.style.border = '1px solid red';
		errAmount.innerHTML = 'Please enter amount!';
	}
	else {
		
		errAmount.innerHTML = '';
	}
	}
	return false;
}*/

