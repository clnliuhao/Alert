package space.liuhao.alert_api_packaging;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;

import java.io.IOException;

/**
 * 声音提醒类
 *
 * @author 刘浩 2015-12-08 10-50
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public class VoiceAlert {
    /**
     * 通知音
     *
     * @param context 上下文实体
     * @throws IOException 设置声音源文件和准备播放时可能会抛出IO异常
     */
    public static final void announcementTone(Context context) throws IOException {
        // 使用来电铃声的铃声路径
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        // 如果为空，才构造，不为空，说明之前有构造过
        MediaPlayer mMediaPlayer = null;
        mMediaPlayer = new MediaPlayer();
        try {
            mMediaPlayer.setDataSource(context, uri);
        } catch (IOException e) {
            throw new IOException(e);
        }
        mMediaPlayer.setLooping(false); //循环播放
        try {
            mMediaPlayer.prepare();
        } catch (IOException e) {
            throw new IOException(e);
        }
        mMediaPlayer.start();
    }
}
