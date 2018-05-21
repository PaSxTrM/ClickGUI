package me.xtrm.ClickGUI.objects;

import java.io.IOException;
import java.util.ArrayList;

import your.Client.module.Category;
import your.Client.module.ModuleManager;
import your.Client.clickgui.ClickGUI;

import me.xtrm.ClickGUI.utils.ColorUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class CPanel {
	
	public int x, y, width, height;
	public int fullheight, maxFullheight;
	public boolean extended;
	
	public ArrayList<MButton> elements;
	
	public Category cat;
	public ClickGUI parent;
	
	public boolean dragging;
	
	public CPanel(Category cat, int x, int y, int width, int height, ClickGUI parent) {		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.cat = cat;
		this.parent = parent;
	}
	
	public void setup() {
		elements = new ArrayList<MButton>();
		
		for(Module m : ModuleManager.getModules()) { // or Client.instance.moduleManager.getModules() (use what you have)
			if(m.getCategory() == cat) {
				elements.add(new MButton(m, 88, height, this));
			}
		}
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		Gui.drawRect(x, y, x + width, y + height, ColorUtils.getClickGUIColor().getRGB());
		
		String name = Character.toUpperCase(cat.name().charAt(0)) + cat.name().toLowerCase().substring(1);
		
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(name, x + 3, y + 3, 0xFFFFFF);
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(extended ? "-" : "+", x + width - 10, y + 3, 0xFFFFFF);
		
		updateMBCoords();

		if(this.extended){
			for(MButton mb : elements){
				if(mb.visible){
					mb.drawScreen(mouseX, mouseY, partialTicks);
				}
			}
		}
	}
	
	/**
	 * Updates coords for MButtons (TODO: Animation)
	 */
	public void updateMBCoords() {
		int yPos = y + height;
		for(MButton mb : elements) {
			mb.x = x + 1;
			mb.y = yPos;
			yPos += mb.height;
		}
	}

	public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if(mouseButton == 1 && isHovered(mouseX, mouseY)) {
			this.extended = !extended;
		}
	}

	public void mouseReleased(int mouseX, int mouseY, int state) {
		
	}

	public void keyTyped(char typedChar, int keyCode) throws IOException {
		
	}
	
	public boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
	}
	
	public boolean isHoveredUp(int mouseX, int mouseY) {
		return mouseX >= x && mouseX <= x + width && mouseY >= y - height && mouseY <= y;
	}

}