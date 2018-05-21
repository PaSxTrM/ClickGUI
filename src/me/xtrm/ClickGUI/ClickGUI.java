package me.xtrm.ClickGUI;

import java.io.IOException;
import java.util.ArrayList;

import your.Client.module.Category;
import your.Client.clickgui.objects.CPanel;

import net.minecraft.client.gui.GuiScreen;

public class ClickGUI extends GuiScreen {
	
	public ArrayList<CPanel> elements;
	
	public ClickGUI() {
		elements = new ArrayList<CPanel>();	
		
		int x = 5;
		int y = 10;
		for(Category cat : Category.values()) {
			if(cat != Category.DEV && cat != Category.GUI) {
				CPanel cp;
				elements.add(cp = new CPanel(cat, x, y, 90, 15, this));
				
				x += 95;
			}
		}
		
		for(CPanel cp : elements) {
			cp.setup();
		}
	}

	@Override
	public void initGui() {
		
		super.initGui();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		for(CPanel cp : elements) {
			cp.drawScreen(mouseX, mouseY, partialTicks);
		}
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		
		for(CPanel cp : elements) {
			cp.mouseClicked(mouseX, mouseY, mouseButton);
		}
		
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		
		for(CPanel cp : elements) {
			cp.mouseReleased(mouseX, mouseY, state);
		}
		
		super.mouseReleased(mouseX, mouseY, state);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		
		for(CPanel cp : elements) {
			cp.keyTyped(typedChar, keyCode);
		}
		
		super.keyTyped(typedChar, keyCode);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
	
}
