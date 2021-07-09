import mongoose from "mongoose"

const usuariosSchema = new mongoose.Schema({
    _id:String,
    nombres:String,
    apellidos:String,
    num_telef:String,
    password:String

})

export default mongoose.model("Usuarios",usuariosSchema);