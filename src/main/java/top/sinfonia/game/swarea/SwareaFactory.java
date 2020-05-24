package top.sinfonia.game.swarea;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import top.sinfonia.game.swarea.common.SwareaConstants;
import top.sinfonia.game.swarea.common.SwareaEntityNames;
import top.sinfonia.game.swarea.components.PlayerComponent;

import static top.sinfonia.game.swarea.common.SwareaConstants.SQUARE_SIZE;

/**
 * @author sunzhaojie
 * @date 2020/5/22
 */
public class SwareaFactory implements EntityFactory {


    @Spawns(SwareaEntityNames.BACKGROUND)
    public Entity newBackground(SpawnData data) {
        return FXGL.entityBuilder()
                .at(0, 0)
                .view(new Rectangle(SwareaConstants.WINDOW_INIT_WIDTH, SwareaConstants.WINDOW_INIT_HEIGHT, Color.LIGHTGREEN))
                .zIndex(-1)
                .build();
    }

    @Spawns(SwareaEntityNames.PLAYER)
    public Entity newPlayer(SpawnData data) {
        Entity player = FXGL.entityBuilder()
                .type(SwareaType.PLAYER)
                .from(data)
                .viewWithBBox(new Rectangle(SQUARE_SIZE, SQUARE_SIZE, Color.ORANGE))
                .with(new CollidableComponent(true))
                .with(new PlayerComponent())
                .build();

        FXGL.getGameScene().getViewport()
                .setBounds(0, 0, FXGL.getAppWidth(), FXGL.getAppHeight());

        return player;
    }
}
