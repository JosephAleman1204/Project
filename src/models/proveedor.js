const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const Proveedor = sequelize.define('Proveedor', {
  nombre: { type: DataTypes.STRING, allowNull: false },
  direccion: { type: DataTypes.STRING },
  telefono: { type: DataTypes.STRING },
  email: { type: DataTypes.STRING, unique: true },
  sitioWeb: { type: DataTypes.STRING },
  sector: { type: DataTypes.STRING },
  fechaRegistro: { type: DataTypes.DATE, defaultValue: DataTypes.NOW },
});

module.exports = Proveedor;
