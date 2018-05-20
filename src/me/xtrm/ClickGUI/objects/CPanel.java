package me.xtrm.E_xTrM.ui.clickgui.meilleurquelancien.objects;

import java.io.IOException;
import java.util.ArrayList;

import me.xtrm.E_xTrM.module.Module.Category;
import me.xtrm.E_xTrM.ui.clickgui.meilleurquelancien.ClickGUI;
import me.xtrm.E_xTrM.utils.ColorUtil;
import me.xtrm.E_xTrM.utils.Wrapper;
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
		elements = new ArrayList<MButton>();
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.cat = cat;
		this.parent = parent;
	}
	
	public void setup() {
		
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		Gui.drawRect(x, y, x + width, y + height, ColorUtil.getClickGUIColor().getRGB());
		
		String smh = Character.toUpperCase(cat.name().charAt(0)) + cat.name().toLowerCase().substring(1);
		Wrapper.fr.drawStringWithShadow(smh, x + 3, y + 3, 0xFFFFFF);
		
		Wrapper.fr.drawStringWithShadow(extended ? "-" : "+", x + width - 10, y + 3, 0xFFFFFF);
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
