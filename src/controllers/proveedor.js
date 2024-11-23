const Proveedor = require('../models/proveedor');

exports.crearProveedor = async (req, res) => {
  try {
    const proveedor = await Proveedor.create(req.body);
    res.status(201).json(proveedor);
  } catch (error) {
    res.status(400).json({ error: error.message });
  }
};

exports.obtenerProveedores = async (req, res) => {
  const proveedores = await Proveedor.findAll();
  res.json(proveedores);
};
