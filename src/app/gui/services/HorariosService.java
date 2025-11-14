package app.gui.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import app.gui.modelo.Camarero;
import app.gui.modelo.Usuario;
import app.gui.mongo.MongoSession;



public class HorariosService {

	public String insertarUsuario(Usuario usuario) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Usuario> c = db.getCollection("usuario", Usuario.class);
		InsertOneResult result = c.insertOne(usuario);
		return result.getInsertedId().toString();
	}

	public Usuario consultarUsuario(String nombre) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Usuario> c = db.getCollection("usuario", Usuario.class);
		Bson filter = Filters.eq("nombre", nombre);
		FindIterable<Usuario> result = c.find(filter);
		return result.first();
	}

	public List<String> consultarNombreDeUsuarios() {
		List<String> nombres = new ArrayList<>();
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Camarero> c = db.getCollection("camarero", Camarero.class);
		FindIterable<Camarero> result = c.find();
		try (MongoCursor<Camarero> cursor = result.iterator()) {
			while (cursor.hasNext()) {
				Camarero camarero = cursor.next();
				nombres.add(camarero.getNombre());
			}
		}
		return nombres;
	}

	public String insertarCamarero(Camarero camarero) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Camarero> c = db.getCollection("camarero", Camarero.class);
		InsertOneResult result = c.insertOne(camarero);
		return result.getInsertedId().toString();
	}

	public Camarero consultarCamarero(String nombre) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Camarero> c = db.getCollection("camarero", Camarero.class);
		Bson filter = Filters.eq("nombre", nombre);
		FindIterable<Camarero> result = c.find(filter);
		return result.first();
	}

	public List<Camarero> consultarCamareros() {
		List<Camarero> paginas = new ArrayList<Camarero>();
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Camarero> c = db.getCollection("camarero", Camarero.class);
		FindIterable<Camarero> result = c.find();
		MongoCursor<Camarero> cursor = result.cursor();
		while (cursor.hasNext()) {
			paginas.add(cursor.next());
		}
		return paginas;
	}

	public void actualizarCamarero(Camarero camarero, Map<String, Boolean> disponibilidad) {
		// Obtener la colección de usuarios de la base de datos
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Camarero> c = db.getCollection("camarero", Camarero.class);

		// Crear un filtro para encontrar el usuario por su correo
		Bson filtro = Filters.eq("nombre", camarero.getNombre());

		if (camarero.getDisponibilidad() == null) {
			camarero.setDisponibilidad(new HashMap<>());
		}
		camarero.getDisponibilidad().putAll(disponibilidad);

		// Realizar la actualización
		UpdateResult result = c.replaceOne(filtro, camarero);

		// Manejar el resultado si es necesario
		if (result.getModifiedCount() != 1) {
			// La actualización no se realizó correctamente
			System.out.println("Error al actualizar el usuario.");
		} else {
			// La actualización se realizó con éxito
			System.out.println("Usuario actualizado con éxito.");
		}
	}

	public void borrarDisponibilidadUnCamarero(Camarero camarero) {
		// Obtener la colección de camareros de la base de datos
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Camarero> c = db.getCollection("camarero", Camarero.class);

		// Crear un filtro para encontrar el camarero por su nombre
		Bson filtro = Filters.eq("nombre", camarero.getNombre());

		// Crear un mapa vacío para la disponibilidad del camarero
		Map<String, Boolean> disponibilidadVacia = new HashMap<>();

		// Actualizar el camarero con el mapa de disponibilidad vacío
		camarero.setDisponibilidad(disponibilidadVacia);

		// Realizar la actualización
		UpdateResult result = c.replaceOne(filtro, camarero);

		// Manejar el resultado si es necesario
		if (result.getModifiedCount() != 1) {
			// La actualización no se realizó correctamente
			System.out.println("Error al borrar la disponibilidad del camarero.");
		} else {
			// La actualización se realizó con éxito
			System.out.println("Disponibilidad del camarero borrada con éxito.");
		}
	}

	public void borrarDisponibilidadDeTodosLosCamareros() {
		// Obtener la colección de camareros de la base de datos
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Camarero> c = db.getCollection("camarero", Camarero.class);

		// Crear un mapa vacío para la disponibilidad
		Map<String, Boolean> disponibilidadVacia = new HashMap<>();

		// Crear un filtro vacío para seleccionar todos los documentos
		Bson filtroVacio = new Document();

		// Crear un documento de actualización para establecer la disponibilidad vacía
		Document actualizacion = new Document("$set", new Document("disponibilidad", disponibilidadVacia));

		// Realizar la actualización de todos los documentos en la colección
		UpdateResult result = c.updateMany(filtroVacio, actualizacion);

		// Manejar el resultado si es necesario
		if (result.getModifiedCount() > 0) {
			// Al menos un documento fue modificado correctamente
			System.out.println("Disponibilidad de todos los camareros borrada con éxito.");
		} else {
			// Ningún documento fue modificado
			System.out.println("No se encontraron camareros para borrar la disponibilidad.");
		}
	}

	public Integer numerodeTurnosdeCadaCamarero(Camarero camarero) {
		Map<String, Boolean> disponibilidadDeCamarero = camarero.getDisponibilidad();

		int contador = 0;
		// Recorrer el Map y mostrar las claves donde el valor sea true
		for (Map.Entry<String, Boolean> entry : disponibilidadDeCamarero.entrySet()) {
			if (entry.getValue()) {
				contador += 1;
			}
		}
		return contador;

	}
	//////////pruba de horarios service
}
