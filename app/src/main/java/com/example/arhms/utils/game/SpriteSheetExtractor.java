package com.example.arhms.utils.game;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SpriteSheetExtractor {
    public static Map<String, Bitmap> extractSprites(Bitmap originalBitmap, InputStream jsonInputStream) {
        Map<String, Bitmap> spriteMap = new HashMap<>();

        try {
            int size = jsonInputStream.available();
            byte[] buffer = new byte[size];
            jsonInputStream.read(buffer);
            jsonInputStream.close();
            String jsonString = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String name = jsonObject.getString("name");
                int x = jsonObject.getInt("x");
                int y = jsonObject.getInt("y");
                int width = jsonObject.getInt("width");
                int height = jsonObject.getInt("height");

                Bitmap spriteBitmap = Bitmap.createBitmap(originalBitmap, x, y, width, height);
                spriteMap.put(name, spriteBitmap);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return spriteMap;
    }
}
