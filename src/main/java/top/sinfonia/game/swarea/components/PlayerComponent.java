package top.sinfonia.game.swarea.components;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import top.sinfonia.game.swarea.common.SwareaConstants;

/**
 * @author sunzhaojie
 * @date 2020/5/22
 */
public class PlayerComponent extends Component {
    private TransformComponent position;

    public void left() {
        if (canMove(KeyCode.LEFT)) {
            position.translateX(-SwareaConstants.SQUARE_SIZE);
        }
    }

    public void up() {
        if (canMove(KeyCode.UP)) {
            position.translateY(-SwareaConstants.SQUARE_SIZE);
        }
    }

    public void right() {
        if (canMove(KeyCode.RIGHT)) {
            position.translateX(SwareaConstants.SQUARE_SIZE);
        }
    }

    public void down() {
        if (canMove(KeyCode.DOWN)) {
            position.translateY(SwareaConstants.SQUARE_SIZE);
        }
    }

    private boolean canMove(KeyCode keyCode) {
        switch (keyCode) {
            case LEFT:
                return canMove(position.getPosition(), new Point2D(-SwareaConstants.SQUARE_SIZE, 0));
            case UP:
                return canMove(position.getPosition(), new Point2D(0, -SwareaConstants.SQUARE_SIZE));
            case RIGHT:
                // 向右边移动时，以右边界为基准
                return canMove(position.getPosition().add(SwareaConstants.SQUARE_SIZE, 0), new Point2D(SwareaConstants.SQUARE_SIZE, 0));
            case DOWN:
                return canMove(position.getPosition().add(0, SwareaConstants.SQUARE_SIZE), new Point2D(0, SwareaConstants.SQUARE_SIZE));
            default:
                return false;
        }
    }

    private boolean canMove(Point2D basePosition, Point2D direction) {
        Point2D newPosition = basePosition.add(direction);
        return FXGL.getGameScene()
                .getViewport()
                .getVisibleArea()
                .contains(newPosition);
    }
}
