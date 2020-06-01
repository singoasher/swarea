# FXGL

## 启动类

```
public class SwareaApp extends GameApplication {
    ... ...
}
```

## 设置

### 基本设置

```
@Override
protected void initSettings(GameSettings settings) {
    settings.setWidth(SwareaConstants.WINDOW_INIT_WIDTH);
    settings.setHeight(SwareaConstants.WINDOW_INIT_HEIGHT);
    settings.setTitle("swarea");
    settings.setVersion("1.0.0");
}
```

### 开启默认游戏菜单

> 不设置默认是不开启的，开启后，还是挺炫酷的

```
settings.setMenuEnabled(true);
```

## Game Vars

```
@Override
protected void initGameVars(Map<String, Object> vars) {
    vars.put("stageColor", Color.BLACK);
    vars.put("position", FormatUtil.format(new Point2D(0, 0)));
}
```

## UI

### 基本配置

```
@Override
protected void initUI() {
    Text uiScore = new Text("");
    uiScore.setFont(Font.font(18));
    uiScore.setTranslateX(getAppWidth() - 200);
    uiScore.setTranslateY(50);
    uiScore.fillProperty().bind(getop("stageColor"));
    uiScore.textProperty().bind(getsp("position"));
    addUINode(uiScore);
}
```

### 新增虚拟操作

```
Group dpadView = getInput().createVirtualDpadView();
FXGL.addUINode(dpadView, 0, 625);
```
