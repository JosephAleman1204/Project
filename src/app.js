const express = require('express');
const dispositivosRoutes = require('./routes/dispositivos');
require('./config/database').sync({ force: true }); // Esto recreará las tablas

const app = express();
app.use(express.json());
app.use('/dispositivos', dispositivosRoutes);

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => console.log(`Servidor en puerto ${PORT}`));
