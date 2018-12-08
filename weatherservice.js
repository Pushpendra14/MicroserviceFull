//npm install --save express

let app = require("express")();

app.get("/weather/:city", (req, res) => {
	let { city } = req.params;
	let message = `Temperature of ${city} is ${Math.random() * 100}`;
	res.end(message);
});

app.listen(4000);
console.log("server started in 4000");