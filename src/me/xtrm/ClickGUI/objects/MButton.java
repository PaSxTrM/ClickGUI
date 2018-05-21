package me.xtrm.E_xTrM.ui.clickgui.meilleurquelancien.objects;

import java.io.IOException;
import java.util.ArrayList;

import your.Client.module.Module;
import your.Client.clickgui.ClickGUI;

public class MButton {
	
	public int x, y, width, height, anim;
	public boolean extended;
	
	public ArrayList<EObject> elements;
	
	public Module module;
	public ClickGUI parent;
	
	public MButton(Module module, int x, int y, ClickGUI parent) {
		elements = new ArrayList<EObject>();
		
		this.x = x;
		this.y = y;
		
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
