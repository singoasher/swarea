package top.sinfonia.game.swarea.common;

import javafx.geometry.Point2D;

/**
 * @author sunzhaojie
 * @date 2020/5/24
 */
public class FormatUtil {

    public static String format(Point2D point2D) {
        return String.format("(%s, %s)", point2D.getX(), point2D.getY());
    }
}
