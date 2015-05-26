package eu.crushedpixel.replaymod.gui.overlay;

import eu.crushedpixel.replaymod.ReplayMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static eu.crushedpixel.replaymod.gui.overlay.GuiReplayOverlay.TEXTURE_SIZE;
import static eu.crushedpixel.replaymod.gui.overlay.GuiReplayOverlay.replay_gui;

/**
 * Renders overlay during recording.
 */
public class GuiRecordingOverlay {
    private final Minecraft mc;

    public GuiRecordingOverlay(Minecraft mc) {
        this.mc = mc;
    }

    /**
     * Render the recording icon and text in the top left corner of the screen.
     * @param event Rendered post game overlay
     */
    @SubscribeEvent
    public void renderRecordingIndicator(RenderGameOverlayEvent.Post event) {
        if (event.type != RenderGameOverlayEvent.ElementType.ALL) return;
        if(ReplayMod.replaySettings.showRecordingIndicator()) {
            FontRenderer fontRenderer = mc.fontRendererObj;
            fontRenderer.drawString(I18n.format("replaymod.gui.recording").toUpperCase(), 30, 18 - (fontRenderer.FONT_HEIGHT / 2), 0xffffffff);
            mc.renderEngine.bindTexture(replay_gui);
            GlStateManager.resetColor();
            GlStateManager.enableAlpha();
            Gui.drawModalRectWithCustomSizedTexture(10, 10, 58, 20, 16, 16, TEXTURE_SIZE, TEXTURE_SIZE);
        }
    }
}
