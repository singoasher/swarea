package top.sinfonia.game.swarea;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.GameWorld;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import top.sinfonia.game.swarea.common.FormatUtil;
import top.sinfonia.game.swarea.common.SwareaConstants;
import top.sinfonia.game.swarea.common.SwareaEntityNames;
import top.sinfonia.game.swarea.components.PlayerComponent;

import java.util.Map;

import static com.almasb.fxgl.dsl.FXGL.*;

/**
 * @author sunzhaojie
 * @date 2020/5/20
 */
public class SwareaApp extends GameApplication {
    private PlayerComponent playerComponent;

    @Override
    protected void initUI() {
        Text uiScore = new Text("");
        uiScore.setFont(Font.font(18));
        uiScore.setTranslateX(getAppWidth() - 200);
        uiScore.setTranslateY(50);
        uiScore.fillProperty().bind(getop("stageColor"));
        uiScore.textProperty().bind(getsp("position"));

        addUINode(uiScore);

        Group dpadView = getInput().createVirtualDpadView();

        addUINode(dpadView, 0, 625);
    }

    @Override
    protected void onUpdate(double tpf) {
        FXGL.set("position", FormatUtil.format(playerComponent.getEntity().getPosition()));
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("stageColor", Color.BLACK);
        vars.put("position", FormatUtil.format(new Point2D(0, 0)));
    }

    @Override
    protected void initInput() {
        FXGL.onKey(KeyCode.LEFT, () -> playerComponent.left());
        FXGL.onKey(KeyCode.UP, () -> playerComponent.up());
        FXGL.onKey(KeyCode.RIGHT, () -> playerComponent.right());
        FXGL.onKey(KeyCode.DOWN, () -> playerComponent.down());
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
