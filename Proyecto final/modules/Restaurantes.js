import mongoose from "mongoose"

const schema = new mongoose.Schema({
    _id:String,
    nombre:String,
    direccion:String,
    telefono:String
},
{ collection : 'resturantes' })


export default mongoose.model("Restaurantes",schema)