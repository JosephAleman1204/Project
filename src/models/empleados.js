const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const Empleado = sequelize.define('Empleado', {
  nombre: { type: DataTypes.STRING, allowNull: false },
  email: { type: DataTypes.STRING, unique: true, allowNull: false },
  contraseña: { type: DataTypes.STRING, allowNull: false },
  rol: { type: DataTypes.ENUM('coordinador', 'validador'), allowNull: false },
  fechaContratacion: { type: DataTypes.DATE, allowNull: false },
  ultimoAcceso: { type: DataTypes.DATE },
  estado: { type: DataTypes.ENUM('activo', 'inactivo'), defaultValue: 'activo' },
});

module.exports = Empleado;
