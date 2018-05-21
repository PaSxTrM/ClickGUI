package me.xtrm.ClickGUI.objects;

import java.io.IOException;
import java.util.ArrayList;

import your.Client.module.Module;

public class MButton {
	
	public int x, y, width, height;
	public boolean extended;
	
	public ArrayList<EObject> elements;
	
	public Module module;

	public CPanel parent;
	
	public MButton(Module module, int width, int height, CPanel parent) {
		elements = new ArrayList<EObject>();
		
		this.x = 0;
		this.y = 0;
		this.width = width;
		this.height = height;
		
		this.module = module;
		this.parent = parent;
	}
	
	public void initGui() {
		
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
	}

	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		
	}

	protected void mouseReleased(int mouseX, int mouseY, int state) {
		
	}

	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		
	}
	
	public boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
	}
	
	public boolean isHoveredUp(int mouseX, int mouseY) {
		return mouseX >= x && mouseX <= x + width && mouseY >= y - height && mouseY <= y;
	}

}