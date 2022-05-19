let studentObj = {
                name: 'abc',
                dateOfBirth: '2021-07-01'
            }

$.ajax({
	headers: {
		'Accept': 'application/json',
		'Content-Type': 'application/json'
	},
    type: "POST", //GET, DELETE, PUT...
    url: "/getPosts/",
    data: JSON.stringify(studentObj),
    success: function(resultSuccess){
        console.log(resultSuccess);
    },
	error: function(resultError) {
		
	}
});