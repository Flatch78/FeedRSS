import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {

  public visible = false;
  private visibleAnimate = false;
  
  constructor() { }

  ngOnInit() {
  }

  public show(): void {
    this.visible = true;
    setTimeout(() => this.visibleAnimate = true);
  }

  public hide(event: any): void {
    if (event.target.className === "modal fade in") {
      this.visibleAnimate = false;
      setTimeout(() => this.visible = false, 300); 
    }
  }
}
