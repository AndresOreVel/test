const express = require("express");
const cors = require("cors");
const app = express();

const PORT = 3000;

// let whitelist = ["http://localhost:5500"];

// // Middleware
// app.use(
//     cors({
//         origin: function (origin, callback) {
//             console.log("origin=>"+origin);
//             if (!origin) return callback(null, true);
//             if (whitelist.indexOf(origin) === -1) {
//                 var message =
//                     "The CORS policy for this origin doesnt " +
//                     "allow access from the particular origin.";
//                  return callback(new Error(message), false);
//             }
//             return callback(null, true);
//         },
//     })
// );

//Accept all request
app.use(cors({
    origin: function(origin, callback){
        return callback(null, true); 
    }
}));

app.get("/getConfig", (req, res) => {
    let config = {
        panellVisible: "principal",
        usuari: "pol",
        rols:"admin"
    };
    console.log(config);
    let str = JSON.stringify(config);
    //res.setHeader("Content-Type","application/json");
    //res.send(str);
    res.json(config);
});

app.listen(PORT, () =>{
    console.log("Server running =>"+PORT);
});