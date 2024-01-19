var app = new Vue({
    el:"#app",
    data: {
        response: {}
    },
    methods: {
        getData: function (){
            console.log("get data");
            const myHeaders = new Headers();

            fetch("http://localhost:3000/getConfig",
             {
                method: 'GET',
                headers: myHeaders,
                mode: 'cors',
                //cache: 'default',
              }
            ).then(
                (response)=> {
                    console.log(response);
                    return response.json()
                }

            ).then((data)=>{
                console.log("DATA=> ");
                console.log(data)
                this.response = data;
            }).catch((error) => {
                console.error('Error:', error);
              });
        },

    },
});

var randomQuestions = null;
function getPreguntes(){

    var promise = fetch("http://localhost:3000/getConfig");
    
    var promise2 = promise.then(
        function(response){
            console.log(response);
            return response.json();
        }
        );

    promise2.then(
        function(datos){
            console.log(datos);
            randomQuestions = datos;
        }
    );

    fetch(url).then(
        (response) => response.json
    ).then(
        (datos) => {
            console.log(datos);
            randomQuestions = datos;
        }
    )
        
        
        console.log("FECTH EXECUTAT!!!");

}