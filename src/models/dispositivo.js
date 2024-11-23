const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');
const Proveedor = require('./proveedor');
const Empleado = require('./empleado');

const Dispositivo = sequelize.define('Dispositivo', {
  imei: { type: DataTypes.STRING, unique: true, allowNull: false },
  estado: { type: DataTypes.ENUM('LISTO_PARA_USAR', 'USADO', 'CANCELADO'), allowNull: false },
  puntaje: { type: DataTypes.INTEGER, allowNull: false },
  fechaValidacion: { type: DataTypes.DATE },
});

Dispositivo.belongsTo(Proveedor);
Dispositivo.belongsTo(Empleado, { as: 'validadoPor' });

module.exports = Dispositivo;
