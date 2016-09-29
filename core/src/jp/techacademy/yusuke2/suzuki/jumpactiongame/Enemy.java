package jp.techacademy.yusuke2.suzuki.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by yusus on 2016/09/29.
 */

public class Enemy extends GameObject {
    // 横幅、高さ
    public static final float Enemy_WIDTH = 1.0f;
    public static final float Enemy_HEIGHT = 1.0f;

    //動くタイプ宣言
    public static final int Enemy_TYPE_MOVING = 1;

    // 速度
    public static final float Enemy_VELOCITY = 3.0f;

    // 状態
    public static final int Enemy_EXIST = 0;

    int mState;
    int mType;

    public Enemy(int type, Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(Enemy_WIDTH, Enemy_HEIGHT);
        mType = type;
        if (mType == Enemy_TYPE_MOVING) {
            velocity.x = Enemy_VELOCITY;
        }
    }

    // 座標を更新
    public void update(float deltaTime) {
        if (mType == Enemy_TYPE_MOVING) {
            setX(getX() + velocity.x * deltaTime);

            if (getX() < Enemy_WIDTH / 2) {
                velocity.x = -velocity.x;
                setX(Enemy_WIDTH / 2);
            }
            if (getX() > GameScreen.WORLD_WIDTH - Enemy_WIDTH / 2) {
                velocity.x = -velocity.x;
                setX(GameScreen.WORLD_WIDTH - Enemy_WIDTH / 2);
            }
        }
    }
    //静的な場合はこちらの動作とする。
//    public Enemy(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
//        super(texture, srcX, srcY, srcWidth, srcHeight);
//        setSize(Enemy_WIDTH, Enemy_HEIGHT);
//        mState = Enemy_EXIST;
//    }

}