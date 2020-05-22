package top.sinfonia.game.swarea;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.GameWorld;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import top.sinfonia.game.swarea.common.SwareaConstants;
import top.sinfonia.game.swarea.common.SwareaEntityNames;
import top.sinfonia.game.swarea.components.PlayerComponent;

/**
 * @author sunzhaojie
 * @date 2020/5/20
 */
public class SwareaApp extends GameApplication {
    private PlayerComponent playerComponent;

    @Override
    protected void initInput() {
        Input input = FXGL.getInput();
        input.addAction(new UserAction(KeyCode.UP.getName()) {
            @Override
            protected void onActionBegin() {
                playerComponent.moveUp();
            }
        }, KeyCode.UP);

        input.addAction(new UserAction(KeyCode.LEFT.getName()) {
            @Override
            protected void onActionBegin() {
                playerComponent.moveLeft();
            }
        }, KeyCode.LEFT);

        input.addAction(new UserAction(KeyCode.DOWN.getName()) {
            @Override
            protected void onActionBegin() {
                playerComponent.moveDown();
            }
        }, KeyCode.DOWN);

        input.addAction(new UserAction(KeyCode.RIGHT.getName()) {
            @Override
            protected void onActionBegin() {
                playerComponent.moveRight();
            }
        }, KeyCode.RIGHT);
    }

    @Override
    protected void initGame() {
        GameWorld gameWorld = FXGL.getGameWorld();
        gameWorld.addEntityFactory(new SwareaFactory());

        // 生成实体
        gameWorld.spawn(SwareaEntityNames.BACKGROUND);
        Entity player = gameWorld.spawn(SwareaEntityNames.PLAYER);
        this.playerComponent = player.getComponent(PlayerComponent.class);

        FXGL.loopBGM("WanAnMiao.mp3");
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(SwareaConstants.WINDOW_INIT_WIDTH);
        settings.setHeight(SwareaConstants.WINDOW_INIT_HEIGHT);
        settings.setTitle("swarea");
        settings.setVersion("1.0.0");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
