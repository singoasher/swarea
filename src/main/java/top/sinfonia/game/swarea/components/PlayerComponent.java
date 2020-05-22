package top.sinfonia.game.swarea.components;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;
import top.sinfonia.game.swarea.common.SwareaConstants;

/**
 * @author sunzhaojie
 * @date 2020/5/22
 */
public class PlayerComponent extends Component {
    private TransformComponent position;

    public void moveRight() {
        position.translateX(SwareaConstants.SQUARE_SIZE);
    }

    public void moveLeft() {
        position.translateX(-SwareaConstants.SQUARE_SIZE);
    }

    public void moveUp() {
        position.translateY(-SwareaConstants.SQUARE_SIZE);
    }

    public void moveDown() {
        position.translateY(SwareaConstants.SQUARE_SIZE);
    }
}
