const { procesarCSV } = require('../utils/csvParser');
const Dispositivo = require('../models/dispositivo');

exports.validarDispositivos = async (req, res) => {
  try {
    const dispositivos = await procesarCSV(req.file.path);
    // Procesar y guardar dispositivos validados en la base de datos
    res.json({ message: 'Dispositivos validados correctamente', dispositivos });
  } catch (error) {
    res.status(400).json({ error: error.message });
  }
};
