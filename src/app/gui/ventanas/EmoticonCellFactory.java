package app.gui.ventanas;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class EmoticonCellFactory implements Callback<ListView<Boolean>,ListCell<Boolean>>{

	@Override
	public ListCell<Boolean> call(ListView<Boolean> param) {
		return new ListCell<Boolean>() {
			@Override
			protected void updateItem(Boolean item, boolean empty) {
				super.updateItem(item, empty);

				if (empty || item == null) {
					setText(null);
					setGraphic(null);
				} else {
					ImageView imageView = new ImageView();
					imageView.setFitWidth(20);
					imageView.setFitHeight(20);
					if (item) {
						// Mostrar un tic verde si el booleano es true
						imageView.setImage(new Image("/app/gui/image/tic_verde.jpg"));
					} else {
						// Mostrar una cruz roja si el booleano es false
						imageView.setImage(new Image("/app/gui/image/cruz_roja.jpg"));
					}
					setGraphic(imageView);
				}
			}
		};
	}

}
