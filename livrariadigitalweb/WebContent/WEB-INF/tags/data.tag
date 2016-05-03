<%@ attribute name="id" required="true" %>
<input id="${id}" name="${id}" />
<script>
	$("#${id}").datepicker({
		dateFormat: 'dd/mm/yy',
    	dayNames: ['Domingo','Segunda','Ter�a','Quarta','Quinta','Sexta','S�bado','Domingo'],
    	dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
    	dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','S�b','Dom'],
    	monthNames: ['Janeiro','Fevereiro','Mar�o','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
    	monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
    	prevText:['m�s anterior'],
		nextText:['pr�ximo m�s']
	});
</script>